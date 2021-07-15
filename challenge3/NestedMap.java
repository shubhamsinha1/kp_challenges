import java.util.HashMap;
import java.util.Map;

public class NestedMap {

    private final Map<String, Object> map;

    public NestedMap() {
        this.map = new HashMap<>();
    }

    public void put(String key, Object object) {
        map.put(key, object);
    }

    public Object get(String key) {
        return map.get(key);
    }

    private static Object getResultRecursive(String[] keys, int keyIndex, NestedMap nestedMap) {
        if ((keys == null) || (keyIndex > keys.length - 1) || (nestedMap == null)) {
            return null;
        }
        String key = keys[keyIndex];
        Object object = nestedMap.map.get(key);
        if (object == null) {
            return null;
        }
        if (!(object instanceof NestedMap)) {
            return object;
        }
        NestedMap nextNestedMap = ((NestedMap)object);
        return getResultRecursive(keys, 1 + keyIndex, nextNestedMap);
    }

    private static Object getResult(String keys, Object object) {
        if ((!(object instanceof NestedMap)) || (keys == null)) {
            return object;
        }
        return getResultRecursive(keys.split("/"), 0, ((NestedMap)object));
    }

    public static void main(String[] args) {
        testa();
        testab();
        testabc();
        testabcd();
    }

    private static void testa() {
        NestedMap nestedMap0 = new NestedMap();
        nestedMap0.put("a", "b");
        String keys = "a";
        Object result = getResult(keys, nestedMap0);
        System.out.println(result);
    }

    private static void testab() {
        NestedMap nestedMap0 = new NestedMap();
        NestedMap nestedMap1 = new NestedMap();
        nestedMap0.put("a", nestedMap1);
        nestedMap1.put("b", "c");
        String keys = "a/b";
        Object result = getResult(keys, nestedMap0);
        System.out.println(result);
    }

    private static void testabc() {
        NestedMap nestedMap0 = new NestedMap();
        NestedMap nestedMap1 = new NestedMap();
        NestedMap nestedMap2 = new NestedMap();
        nestedMap0.put("a", nestedMap1);
        nestedMap1.put("b", nestedMap2);
        nestedMap2.put("c", "d");
        String keys = "a/b/c";
        Object result = getResult(keys, nestedMap0);
        System.out.println(result);
    }

    private static void testabcd() {
        NestedMap nestedMap0 = new NestedMap();
        NestedMap nestedMap1 = new NestedMap();
        NestedMap nestedMap2 = new NestedMap();
        NestedMap nestedMap3 = new NestedMap();
        nestedMap0.put("a", nestedMap1);
        nestedMap1.put("b", nestedMap2);
        nestedMap2.put("c", nestedMap3);
        nestedMap3.put("d", "e");
        String keys = "a/b/c/d";
        Object result = getResult(keys, nestedMap0);
        System.out.println(result);
    }

}
