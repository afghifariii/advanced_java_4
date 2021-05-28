import org.junit.Assert;
import org.junit.Test;

public class BelajarUnitTest {
    public int penjumlahan(int a, int b) {
        return a + b;
    }

    public String menyapa(String nama) {
        return ("Halo, " + nama);
    }

    public boolean isBelajar(String nama) {
        if (nama.equals("ali")) {
            return true;
        } else {
            return false;
        }
    }

    public int[] buatArray(int panjang) {

        int[] temp = new int[panjang];

        for (int i = 0; i < panjang; i++) {
            temp[i] = i;
        }

        return temp;
    }


    @Test
    public void testArray() {
        int[] hasil = buatArray(3); // {0, 1, 2}
        int[] expektasi = {0, 1, 2};

        Assert.assertArrayEquals(expektasi, hasil);
    }

    @Test
    public void testIsBelajar() {
        boolean hasil = isBelajar("john");

//        Assert.assertFalse(hasil);
        Assert.assertEquals(false, hasil);
    }

    @Test
    public void testMenyapa() {
        String hasil = menyapa("ali");

        Assert.assertEquals("Halo, ali", hasil);
    }

    @Test
    public void testMenyapa2() {
        String hasil = menyapa("Ali").toLowerCase();

        Assert.assertEquals("Halo, ali".toLowerCase(), hasil);
    }

    @Test
    public void testPenjumlahan() {
        int a = 5;
        int b = 10;
        int hasil = penjumlahan(5, 10);

        Assert.assertEquals(15, hasil);
    }

    @Test
    public void testPenjumlahanSalah() {
        int a = 5;
        int b = 10;
        int hasil = penjumlahan(a, b);

        Assert.assertEquals(10, hasil);
    }
}
