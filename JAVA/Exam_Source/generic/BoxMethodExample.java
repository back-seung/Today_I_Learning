package generic;public class BoxMethodExample {    public static void main(String[] args) {        Box<Integer> box1 = Util.boxing(100);        int intValue = box1.getItem();        Box<String> box2 = Util.boxing("스트링링");        String strValue = box2.getItem();    }}