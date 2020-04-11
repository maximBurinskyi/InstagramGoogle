package Youtube;

import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Vans_youtube extends Yutube_BaseTest {
    @Test
    public void Test_01_Youtube() throws InterruptedException, IOException {

        GetDataFromVideo_25rows("https://www.youtube.com/user/VansShoes66/videos", "Vans_youtube");

    }
}
