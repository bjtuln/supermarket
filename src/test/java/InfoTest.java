import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/18.
 */
public class InfoTest {
    @Test //商品信息读取
    public void goodInFo_should_return_ITEM00003() {
        Info info = new Info();
        String result = goodInFo.read_GoodInfo_return();
        Assert.assertEquals("ITEM000003", result);
        //Assert.assertEquals("ITEM000002", result);
    }

    @Test //优惠商品信息读取-买三免一
    public void promotionInFo_should_return_ITEM00001() {
        Info info = new Info();
        String result = promotionInFo.read_promotionInFo_return();
        Assert.assertEquals("ITEM000001", result);
        //Assert.assertEquals("ITEM000002", result);
    }


}
