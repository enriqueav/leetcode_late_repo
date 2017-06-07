/*
I am sure a lot of optimization can be done.
Not my most elegant code.
*/
public class Solution {
    public String doLine(ArrayList<String> words,int width, boolean last){
        StringBuilder sb = new StringBuilder();
        int wordsize = 0;
        for( String w : words ){
            wordsize+=w.length();
        }
        int diff = width-wordsize;
        int voids = words.size()-1;
        
        int[] spaces = new int[voids];
        
        if( voids>0 && diff % voids == 0 ){
            Arrays.fill(spaces,(diff/voids));
        } else if(voids>0) {
            
            int min = diff/voids;
            int max = min+1;
            int howManyMax = diff%voids;
            int index = 0;
            for(index=0; index<howManyMax; index++){
                spaces[index]=max;
            }
            for( ; index<spaces.length; index++){
                spaces[index]=min;
            }
        }
        
        for(int i=0; i<words.size(); i++){
            sb.append(words.get(i));
            if( !last && i<words.size()-1 ){
                int spacesToAdd = spaces[i];
                for(int s=0; s<spacesToAdd; s++) sb.append(" ");
            } else if(i<words.size()-1) {
                sb.append(" ");
            }
        }
        while( sb.length() < width ) sb.append(" ");
        return sb.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> l = new ArrayList<String>();
        if( words == null ) return null;
        if( words.length == 0 ){ l.add(""); return l; }
        
        int currentLength = 0;
        ArrayList<String> tmp = new ArrayList<String>();
        for(int i=0; i<words.length; i++){
            String w = words[i];
            int thisLength = w.length();
            if( (currentLength + thisLength) == maxWidth ){
                tmp.add(w);
                l.add( doLine(tmp,maxWidth, true) );
                currentLength = 0;
                tmp.clear();
            } else if( (currentLength + thisLength) > maxWidth ){
                l.add( doLine(tmp, maxWidth, false) );
                i--;
                currentLength = 0;
                tmp.clear();
            } else if(i==(words.length-1)){
                tmp.add(w);
                l.add( doLine(tmp , maxWidth, true) );
            } else {
                tmp.add(w);
                currentLength += (1+thisLength);
            }
        }
        
        return l;
    }
}
