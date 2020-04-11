package Youtube;

import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Hollister_youtube extends Yutube_BaseTest {

    @Test
    public void Test_01_Youtube() throws InterruptedException, IOException {

        GetDataFromVideo_30rows("https://www.youtube.com/user/hollisterclubcali/videos", "Hollister_youtube");

    }
}
