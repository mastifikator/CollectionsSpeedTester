package TestMapCollections;

import java.util.HashMap;
import java.util.WeakHashMap;

public class SpeedWeakHashMap {

    private WeakHashMap weakHashMap;
    private final String COLLECTION_TYPE = "WeakHashMap";

    public SpeedWeakHashMap(WeakHashMap weakHashMap) {
        this.weakHashMap = weakHashMap;
    }

    public void add(HashMap addedMap) {

        System.out.printf("\nТестируем скорость операций добавления элементов в %s \n", COLLECTION_TYPE);
        System.out.println("--------------------------------------------------");

        AddToMap.add(addedMap, weakHashMap, COLLECTION_TYPE);
    }

    public void get(int countOperationsGet) {
        System.out.printf("\nТестируем скорость операций получения элементов из %s \n", COLLECTION_TYPE);
        System.out.println("--------------------------------------------------");

        GetOfMap.get(countOperationsGet, weakHashMap, COLLECTION_TYPE);
    }

    public void remove(int countOperationsRemove) {
        System.out.printf("\nТестируем скорость операций удаления элементов из %s \n", COLLECTION_TYPE);
        System.out.println("--------------------------------------------------");

        RemoveOfMap.remove(countOperationsRemove, weakHashMap, COLLECTION_TYPE);
    }
}