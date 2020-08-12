package utils;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CompareList {

    // If the data in our lists are unique i.e. there isn’t a duplication,
    // we can simply create TreeSets from the given lists and then compare them using equals():
    public static <T extends Comparable<T>> boolean isEquals(List<T> list1, List<T> list2) {
        if (list1 == null && list2 == null) {
            return true;
        } else if (list1 == null || list2 == null) {
            return false;
        } else if (list1.size() != list2.size()) {
            return false;
        }

        Set<T> set1 = new TreeSet<T>(list1);
        Set<T> set2 = new TreeSet<T>(list2);

        return set1.equals(set2);
    }


    /*   to check if the two lists contain the same elements, irrespective of their order in the list
    public <T extends Comparable<T>> boolean isEquals(List<T> list1, List<T> list2){
        if (list1 == null && list2 == null) {
            return true;
        }
        //Only one of them is null
        else if(list1 == null || list2 == null) {
            return false;
        }
        else if(list1.size() != list2.size()) {
            return false;
        }

        //copying to avoid rearranging original lists
        list1 = new ArrayList<T>(list1);
        list2 = new ArrayList<T>(list2);

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }
    */
}
