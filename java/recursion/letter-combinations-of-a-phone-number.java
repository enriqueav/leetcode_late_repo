public class Solution {
    HashMap<Character,ArrayList<Character>> m;
    
    public void buildMap(){
        m = new HashMap<Character,ArrayList<Character>>();
        ArrayList<Character> t = new ArrayList<Character>();
        t.add('a'); t.add('b'); t.add('c');
        m.put('2',t);
        t = new ArrayList<Character>();
        t.add('d'); t.add('e'); t.add('f');
        m.put('3',t);
        t = new ArrayList<Character>();
        t.add('g'); t.add('h'); t.add('i');
        m.put('4',t);
        t = new ArrayList<Character>();
        t.add('j'); t.add('k'); t.add('l');
        m.put('5',t);
        t = new ArrayList<Character>();
        t.add('m'); t.add('n'); t.add('o');
        m.put('6',t);
        t = new ArrayList<Character>();
        t.add('p'); t.add('q'); t.add('r'); t.add('s');
        m.put('7',t);
        t = new ArrayList<Character>();
        t.add('t'); t.add('u'); t.add('v');
        m.put('8',t);
        t = new ArrayList<Character>();
        t.add('w'); t.add('x'); t.add('y'); t.add('z');
        m.put('9',t);
    }
    
    public void lc(String digits, String soFar, ArrayList<String> l){
        if( digits.length() == 1 ){
            ArrayList<Character> chars = m.get(digits.charAt(0));
            for( char thisChar : chars ){
                l.add(soFar+thisChar+"");
            }
        } else {
            ArrayList<Character> chars = m.get(digits.charAt(0));
            for( char thisChar : chars ){
                lc(digits.substring(1), soFar+thisChar+"" , l);
            }
        }
    }
    
    public List<String> letterCombinations(String digits) {
        buildMap();
        ArrayList<String> l = new ArrayList<String>();
        if( digits.length() == 0 ) return l;
        lc(digits,"",l);
        return l;
    }
}
