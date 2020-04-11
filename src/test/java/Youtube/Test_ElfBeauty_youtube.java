package Youtube;

import org.testng.annotations.Test;

import java.io.IOException;

public class Test_ElfBeauty_youtube extends Yutube_BaseTest {

    @Test
    public void likTest_01_Youtube() throws InterruptedException, IOException {

        GetDataFromVideo_30rows("https://www.youtube.com/user/eyeslipsfacedotcom/videos", "ElfBeauty_youtube");

    }
}
