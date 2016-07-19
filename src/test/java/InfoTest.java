import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/7/18.
 */
public class InfoTest {

    @Test //商品信息读取（从第一行算起-1）
    public void goodInFo_should_return_ITEM00000() {
        Info info = new Info();
        String file_GoodInfo = "src/main/resource/test-goodInfo.txt";
        ArrayList<String> arraylist;
        arraylist = goodInFo.read_GoodInfo(file_GoodInfo);
        String result[]=arraylist.get(1).split("\\s+");
        //第一行读取奇怪的点，从第二行开始是实际用的数据
        Assert.assertEquals("ITEM000000", result[0]);
    }

    @Test //商品信息读取（从第一行算起-5）
    public void goodInFo_should_return_ITEM00004() {
        Info info = new Info();
        String file_GoodInfo = "src/main/resource/test-goodInfo.txt";
        ArrayList<String> arraylist;
        arraylist = goodInFo.read_GoodInfo(file_GoodInfo);
        String result[]=arraylist.get(5).split("\\s+");
        //第一行读取奇怪的点，从第二行开始是实际用的数据
        Assert.assertEquals("ITEM000004", result[0]);
    }

    @Test //商品优惠信息读取-买三免一
    public void promotionInFo_should_return_ITEM00001(){
        Info info = new Info();
        String file_promotionInfo = "src/main/resource/test-promotionInfo.txt";
        ArrayList<String> arraylist;
        arraylist = promotionInFo.read_PromotionInfo(file_promotionInfo);
        String result[]=arraylist.get(1).split("\\s+");
        //第一行读取奇怪的点，从第二行开始是实际用的数据
        Assert.assertEquals("ITEM000001", result[0]);
    }

    @Test //买三免一计算-买一个正常的可乐
    public void should_return_3(){
        Info info = new Info();
        String file_promotionInfo = "src/main/resource/test-promotionInfo.txt";
        ArrayList<String> arraylist;
        arraylist = promotionInFo.read_PromotionInfo(file_promotionInfo);
        String result[]=arraylist.get(1).split("\\s+");
        //第一行读取奇怪的点，从第二行开始是实际用的数据
        Assert.assertEquals("ITEM000001", result[0]);
    }


    /*@Test //正常商品价格-ITEM00003*1
    public void calculate_NormalInfo_should_return_5_1() {
        purchaseInFo purchaseinfo = new purchaseInFo();
        float result = purchaseInFo.calculate_NormalInfo_return1();
        Assert.assertEquals("5.00", String.valueOf(result));

    }*/
}
