package set;
import binarysearchtree.BinarySearchTree;

import java.util.ArrayList;

/**
 * @Auther: Alex
 * @Date: 2021/3/10 - 03 - 10 -14:37
 * @Description: set
 * @Verxion: 1.0
 */
public class Main {
    private static double testSet(Set<String> set,String filename) {
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename,words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words) set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }
    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";
        BinarySearchTreeSet<String> bstSet = new BinarySearchTreeSet<>();
        double time1 = testSet(bstSet,filename);
        System.out.println("BinarySearchTreeSet: " + time1 + "s");

        System.out.println();
        LinkedListSet<String> llSet = new LinkedListSet<>();
        double time2 = testSet(llSet,filename);
        System.out.println("LinkedListSet: " + time2 + "s");
    }
}
