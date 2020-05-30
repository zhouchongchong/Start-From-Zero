package com.javascience.start.zero.javazero;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

class DemoApplicationTests {
	public static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	@Test
	public void contextLoads() {
		final Vector<Integer> integers = new Vector<>(5, 4);
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		integers.insertElementAt(7, 2);

		logger.info("Vector 容量{}", integers.capacity());
	}

	@Test
	public void testStack() {
		final Stack<Integer> integers = new Stack<>();
		integers.add(1);
		final Integer peek = integers.peek();
		integers.pop();
		logger.info("e:{},empty:{}", peek, integers.empty());

	}

	@Test
	public void testHashtable() {
		final Hashtable<String, String> stringStringHashtable = new Hashtable<>();
		stringStringHashtable.put("1", "2");
		stringStringHashtable.put("1", "3");
		final Set<Map.Entry<String, String>> entries = stringStringHashtable.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			logger.info("key:{},value:{}", entry.getKey(), entry.getValue());
		}

	}


	@Test
	public void testSystm() {
		System.out.println(Integer.MAX_VALUE);
		int val = Integer.MAX_VALUE << 1;
		System.out.println(val);
	}


	/**
	 * 求一个字符串包含的char
	 */
	@Test
	public void containChars() {
		String str = "fasgwerhgwerh";
		BitSet used = new BitSet();
		for (int i = 0; i < str.length(); i++)
			used.set(str.charAt(i)); // set bit for char

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int size = used.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			if (used.get(i)) {
				sb.append((char) i);
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	@Test
	public  void computePrime() {
		BitSet sieve = new BitSet(1024);
		int size = sieve.size();
		for (int i = 2; i < size; i++)
			sieve.set(i);
		int finalBit = (int) Math.sqrt(sieve.size());

		for (int i = 2; i < finalBit; i++)
			if (sieve.get(i))
				for (int j = 2 * i; j < size; j += i)
					sieve.clear(j);

		int counter = 0;
		for (int i = 1; i < size; i++) {
			if (sieve.get(i)) {
				System.out.printf("%5d", i);
				if (++counter % 15 == 0)
					System.out.println();
			}
		}
		System.out.println();
	}

	/**
	 * 进行数字排序
	 */
	@Test
	public void sortArray() {
		int[] array = new int[] { 423, 700, 9999, 2323, 356, 6400, 1,2,3,2,2,2,2 };
		BitSet bitSet = new BitSet(2 << 13);
		// 虽然可以自动扩容，但尽量在构造时指定估算大小,默认为64
		System.out.println("BitSet size: " + bitSet.size());

		for (int i = 0; i < array.length; i++) {
			bitSet.set(array[i]);
		}
		//剔除重复数字后的元素个数
		int bitLen=bitSet.cardinality();

		//进行排序，即把bit为true的元素复制到另一个数组
		int[] orderedArray = new int[bitLen];
		int k = 0;
		for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
			orderedArray[k++] = i;
		}

		System.out.println("After ordering: ");
		for (int i = 0; i < bitLen; i++) {
			System.out.print(orderedArray[i] + "\t");
		}

		System.out.println("iterate over the true bits in a BitSet");
		//或直接迭代BitSet中bit为true的元素iterate over the true bits in a BitSet
		for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
			System.out.print(i+"\t");
		}
		System.out.println("---------------------------");
	}
	@Test
	public void sum(){
		Long sum = 0L;
		Long t1 = System.currentTimeMillis();
		for (long i = 1; i < 10000000; i++){
			sum += i;
		}
		System.out.println(System.currentTimeMillis() - t1);
		System.out.println(sum);
	}
}
