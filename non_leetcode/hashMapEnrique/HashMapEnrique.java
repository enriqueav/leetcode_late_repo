import java.util.ArrayList;

public class HashMapEnrique {
    
    private int MAX_SIZE = 1000;
    private ArrayList<MapEntryEnrique> info[];
    private int size;
 
    public HashMapEnrique(){
    	this.info = new ArrayList[MAX_SIZE];
    	this.size = 0;
    }
    
    public void put(String key, int value){
        int hashed = getHashedKey(key);
        if( info[hashed] == null ){
            info[hashed] = new ArrayList<MapEntryEnrique>();
        }
        if( searchInList(key,info[hashed]) == null ){
        	info[hashed].add(new MapEntryEnrique(key,value));
        	size++;
        }
        else
        	overWriteInList(key,value,info[hashed]);
    }
    
    private void overWriteInList(String key, int value,
			ArrayList<MapEntryEnrique> arrayList) {
    	for( int i=0; i<arrayList.size(); i++ ){
    		if( arrayList.get(i).mapKey.equals(key) ){
    			arrayList.get(i).mapValue = value;
    		}
    	}
	}

	public int get(String key){
        int hashed = getHashedKey(key);
        Integer val = null;
        if( ! (info[hashed] == null) ) 
        {
        	ArrayList<MapEntryEnrique> values = info[hashed];
        	val = searchInList(key,values);
        }
       return val; // OR NullPointerException!
     
    }
 
    private int getHashedKey(String key){
        return Math.abs( key.hashCode() % MAX_SIZE );
    }
    
    public int size(){
    	return this.size;
    }
    
    public void clear(){
    	this.info = new ArrayList[MAX_SIZE];
    	size = 0;
    }
    
    public int remove(String key){
        int hashed = getHashedKey(key);
        Integer val = null;
        if( ! (info[hashed] == null) ) 
        {
        	ArrayList<MapEntryEnrique> values = info[hashed];
        	val = removeInList(key,values);
        	size--;
        }
       return val; // OR NullPointerException!  	
    }
    
    public void print_r(){
    	for( int i=0; i<MAX_SIZE; i++ ){
    		if( info[i] == null ){
    			System.out.println("["+i+"] = null" );
    		} else {
    			System.out.print("["+i+"].size="+info[i].size()+" => ");
    			for( MapEntryEnrique e : info[i] ){
    				System.out.print("("+e.mapKey+","+e.mapValue+")");
    			}
    			System.out.println();
    		}
    	}
    }

    private Integer searchInList(String key,ArrayList<MapEntryEnrique> values){
           for( MapEntryEnrique entry : values ){
        	   if( entry.mapKey.equals(key) ) return entry.mapValue;
           }
           return null;
    }
    
    private Integer removeInList(String key,ArrayList<MapEntryEnrique> values){
        for( int i=0; i<values.size(); i++ ){
        	MapEntryEnrique entry = values.get(i);
     	   if( entry.mapKey.equals(key) ){
     		   Integer retVal = entry.mapValue;
     		   values.remove(i);
     		   return retVal;
     	   }
        }
        return null;
    }
 
}
 
