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

    @Test //正常商品价格-ITEM00003*1
    public void calculate_NormalInfo_should_return_5_1() {
        purchaseInFo purchaseinfo = new purchaseInFo();
        float result = purchaseInFo.calculate_NormalInfo_return1();
        Assert.assertEquals("5.00", String.valueOf(result));

    }
    @Test //正常商品价格-ITEM00003*2
    public void calculate_NormalInfo_should_return_10_2() {
        purchaseInFo purchaseinfo = new purchaseInFo();
        float result = purchaseInFo.calculate_NormalInfo_return2();
        Assert.assertEquals("5.00", String.valueOf(result));

    }
    @Test //正常商品价格-ITEM00003*3
    public void calculate_NormalInfo_should_return_15_3() {
        purchaseInFo purchaseinfo = new purchaseInFo();
        float result = purchaseInFo.calculate_NormalInfo_return3();
        Assert.assertEquals("5.00", String.valueOf(result));

    }

    @Test //促销商品价格-ITEM00001*1
    public void calculate_PromotionInfo_should_return_3_1() {
        purchaseInFo purchaseinfo = new purchaseInFo();
        float result = purchaseInFo.calculate_PromotionInfo_return1();
        Assert.assertEquals("3.00", String.valueOf(result));

    }
    @Test //促销商品价格-ITEM00001*2
    public void calculate_PromotionInfo_should_return_6_2() {
        purchaseInFo purchaseinfo = new purchaseInFo();
        float result = purchaseInFo.calculate_PromotionInfo_return2();
        Assert.assertEquals("3.00", String.valueOf(result));

    }
    @Test //促销商品价格-ITEM00001*3
    public void calculate_PromotionInfo_should_return_6_3() {
        purchaseInFo purchaseinfo = new purchaseInFo();
        float result = purchaseInFo.calculate_PromotionInfo_return3();
        Assert.assertEquals("3.00", String.valueOf(result));

    }


}
