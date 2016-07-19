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

        Assert.assertEquals("ITEM000004", result[0]);
    }

    @Test //商品优惠信息读取-买三免一
    public void promotionInFo_should_return_ITEM00001(){
        Info info = new Info();
        String file_promotionInfo = "src/main/resource/test-promotionInfo.txt";
        ArrayList<String> arraylist;
        arraylist = promotionInFo.read_PromotionInfo(file_promotionInfo);
        String result[]=arraylist.get(1).split("\\s+");

        Assert.assertEquals("ITEM000001", result[0]);
    }
    @Test//95折商品
    public void calculate_DiscountInfo_should_return_4(){
        purchaseInFo purchaseinfo = new purchaseInFo();
        goodInFo goodInFo = new goodInFo();
        String file_GoodInfo = "src/main/resource/test-goodInfo.txt";
        goodInFo.read_GoodInfo(file_GoodInfo);
        //String file_PromotionInfo = "discountInfo.txt";
        ArrayList<String> dis = discountInFo.read_DiscountInfo("src/main/resource/discountInfo.txt");
        purchaseInFo purchaseInFo = new purchaseInFo();
        purchaseInFo.set_Array("ITEM000006", 10);
        purchaseInFo.set_Array("#", 10);
        float result = purchaseInFo.calculate_DiscountInfo(dis);
        System.out.print(result);
        Assert.assertEquals("4.0", String.valueOf(result));
    }

    /*@Test //买三免一计算-单独买一个正常的可乐价钱
    public void should_return_3(){

        String file_GoodInfo = "src/main/resource/test-goodInfo.txt";
        goodInFo.read_GoodInfo(file_GoodInfo);
        String file_PromotionInfo = "src/main/resource/test-promotionInfo.txt";
        promotionInFo.read_PromotionInfo(file_PromotionInfo);
        ArrayList<String> array_purchaseinfo=new ArrayList<String>();
        ArrayList<Integer> array_purchaseinfo_num=new ArrayList<Integer>();
        array_purchaseinfo.add("ITEM000000");
        array_purchaseinfo_num.add(1);
        float result=purchaseInFo.calculate_NormalInfo();
        //result为0并没有得到计算
        Assert.assertEquals("3.00", result);
    }*/

}
