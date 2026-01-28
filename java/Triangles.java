class Triangle {
    public void increasing(int layers) {
        for (int i = 1; i <= layers; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    public void decreasing(int layers) {
        for (int i = layers; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    public void mirrored(int layers) {
        for (int i = 1; i <= layers; i++) {
            for (int j = 1; j <= layers - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= (i - 1) * 2 + 1; k++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    public void weirdTriangle(int layers) {
        for (int i = layers; i >= 1; i--) {
            for (int j = 1; j <= layers - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Triangles {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.increasing(5);
        System.out.println();
        triangle.decreasing(5);
        System.out.println();
        triangle.mirrored(5);
        System.out.println();
        triangle.weirdTriangle(5);
    }
}
