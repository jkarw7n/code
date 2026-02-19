class Unbracket {
    private static String string = "akoayhindi[3nandito]at[2siya][2pa]ayhi[4n]di[5.]";
    public static String unbracket(String s) {
        String newString = "";
        for (char c : s.toCharArray()) {
            if (c != '[' && c != ']') { newString += c; }
            else if (c == '[') { newString += " ["; }
            else { newString += "] "; }
        }
        String split[] = newString.split(" "), output = "";
        for (String e : split) {
            if (!e.contains("[")) { output += e; }
            else {
                int times = Integer.parseInt(e.substring(1, 2));
                for (int i = 0; i < times; i++) {
                    output += e.substring(2, e.length() - 1);
                }
            }
        }
        return output;
    }
    
    public static void main(String[] args) {
        System.out.println(unbracket(string));
    }
}
