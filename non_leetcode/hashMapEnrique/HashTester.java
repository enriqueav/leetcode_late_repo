
public class HashTester {

	public static void main(String[] args) {
		HashMapEnrique m = new HashMapEnrique();

		m.put("uno", 1);
		m.put("dos", 2);
		m.put("tres", 3);
		m.put("cuatro", 4);

		System.out.println(m.get("uno"));
		System.out.println(m.get("dos"));
		System.out.println(m.get("tres"));
		System.out.println("size="+m.size());
		//System.out.println(m.get("cinco")); //NOT FOUND
		m.put("uno", 1222);
		System.out.println(m.get("uno"));
		System.out.println("size="+m.size());
		m.put("cuarenta y cinco", 45);
		System.out.println(m.get("cuarenta y cinco"));
		System.out.println("size="+m.size());
		//m.print_r();
		m.clear();
		System.out.println("size="+m.size());
		//m.print_r();
		//System.out.println("uno".hashCode());
		System.out.println();
		System.out.println();
		System.out.println();
		
		for( int i=0; i<10000; i++ ){
			m.put(NumberToLetterConverter.convertNumberToLetter(i), i);
		}
		System.out.println("size="+m.size());
		//m.print_r();
		for( int i=0; i<5000; i++ ){
			m.remove(NumberToLetterConverter.convertNumberToLetter(i));
		}
		//m.print_r();
		System.out.println("size="+m.size());
		for( int i=0; i<1000; i++ ){
			m.put(NumberToLetterConverter.convertNumberToLetter(i),i*1000);
		}
		m.print_r();
		System.out.println("size="+m.size());
		System.out.println("get 100="+m.get("CIEN"));
	}

}
