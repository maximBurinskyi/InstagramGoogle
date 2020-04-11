package Youtube;

import org.testng.annotations.Test;

import java.io.*;


public class Test_CalvinKlein_youtube extends Yutube_BaseTest {

    @Test
    public void Test_01_Youtube() throws InterruptedException, IOException {

        GetDataFromVideo_25rows("https://www.youtube.com/user/calvinklein/videos", "CalvinKlein_youtube");

        }
    }







