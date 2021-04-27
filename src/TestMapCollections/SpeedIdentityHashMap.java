package TestMapCollections;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class SpeedIdentityHashMap {

    private IdentityHashMap identityHashMap;
    private final String COLLECTION_TYPE = "IdentityHashMap";

    public SpeedIdentityHashMap(IdentityHashMap identityHashMap) {
        this.identityHashMap = identityHashMap;
    }

    public void add(HashMap addedMap) {

        System.out.printf("\nТестируем скорость операций добавления элементов в %s \n", COLLECTION_TYPE);
        System.out.println("--------------------------------------------------");

        AddToMap.add(addedMap, identityHashMap, COLLECTION_TYPE);
    }

    public void get(int countOperationsGet) {
        System.out.printf("\nТестируем скорость операций получения элементов из %s \n", COLLECTION_TYPE);
        System.out.println("--------------------------------------------------");

        GetOfMap.get(countOperationsGet, identityHashMap, COLLECTION_TYPE);
    }

    public void remove(int countOperationsRemove) {
        System.out.printf("\nТестируем скорость операций удаления элементов из %s \n", COLLECTION_TYPE);
        System.out.println("--------------------------------------------------");

        RemoveOfMap.remove(countOperationsRemove, identityHashMap, COLLECTION_TYPE);
    }
}