import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/17.
 */
public class FileInTest {
    public FileInTest() {
    }

    @Test //控制台
    public void should_return_ITEM000001() {
        FileIn filein = new FileIn();
        String result = filein.read_GoodInfo_console("ITEM000001");
        Assert.assertEquals("ITEM000001", result);
    }

    @Test //单数据文件
    public void should_return_ITEM00000() {
        FileIn filein = new FileIn();
        String result = filein.read_GoodInfo();
        Assert.assertEquals("ITEM000000", result);
    }

    @Test //多数据文件
    public void should_return_ITEM00002() {
        FileIn filein = new FileIn();
        String result = filein.read_GoodInfo5();
        Assert.assertEquals("ITEM000003", result);
        //Assert.assertEquals("ITEM000002", result);
    }
}
