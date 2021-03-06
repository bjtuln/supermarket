import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/7/18.
 */
public class InfoTest {
    ArrayList<String> array_dis = new ArrayList<String>();
    @Test //商品信息读取
    public void goodInFo_should_return_ITEM00000() {
        Info info = new Info();
        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        ArrayList<String> arraylist;
        arraylist = GoodInFo.read_GoodInfo(file_GoodInfo);
        String result[]=arraylist.get(1).split("\\s+");
        //第一行读取奇怪的点，从第二行开始是实际用的数据
        Assert.assertEquals("ITEM000000", result[0]);
    }

    @Test //商品信息读取（从第一行算起-5）
    public void goodInFo_should_return_ITEM00004() {
        Info info = new Info();
        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        ArrayList<String> arraylist;
        arraylist = GoodInFo.read_GoodInfo(file_GoodInfo);
        String result[]=arraylist.get(5).split("\\s+");

        Assert.assertEquals("ITEM000004", result[0]);
    }

    @Test //商品优惠信息读取-买二赠一
    public void promotionInFo_should_return_ITEM00001(){
        Info info = new Info();
        String file_promotionInfo = "src/main/resources/test-promotionInfo.txt";
        ArrayList<String> arraylist;
        arraylist = PromotionInFo.read_PromotionInfo(file_promotionInfo);
        String result[]=arraylist.get(1).split("\\s+");

        Assert.assertEquals("ITEM000001", result[0]);
    }

    @Test//95折商品
    public void calculate_DiscountInfo_should_return_4(){
        PurchaseInFo purchaseinfo = new PurchaseInFo();
        GoodInFo goodInFo = new GoodInFo();
        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        goodInFo.read_GoodInfo(file_GoodInfo);
        //String file_PromotionInfo = "discountInfo.txt";
        ArrayList<String> dis = DiscountInFo.read_DiscountInfo("src/main/resources/discountInfo.txt");
        PurchaseInFo PurchaseInFo = new PurchaseInFo();
        PurchaseInFo.set_Array("ITEM000006", 10);
        PurchaseInFo.set_Array("#", 10);
        float result = PurchaseInFo.calculate_DiscountInfo(dis);
        System.out.print(result);
        Assert.assertEquals("4.0", String.valueOf(result));
    }

    @Test //买二赠一计算-单独买一个正常的可乐项目
    public void should_return_purchaseinfo_firstitem(){

        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        GoodInFo.read_GoodInfo(file_GoodInfo);
        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        PromotionInFo.read_PromotionInfo(file_PromotionInfo);
        PurchaseInFo purchaseinfo=new PurchaseInFo();
        PurchaseInFo.array_purchaseinfo.clear();
        PurchaseInFo.array_purchaseinfo_num.clear();
        purchaseinfo.set_Array("ITEM000000",1);
        //float result=PurchaseInFo.calculate_NormalInfo();
        //result为0并没有得到计算
        //Assert.assertEquals("3.00", result);
        String result= PurchaseInFo.array_purchaseinfo.get(0);
        Assert.assertEquals("ITEM000000", result);
    }

    @Test //买二赠一计算-单独买一个正常的可乐个数
    public void should_return_purchaseinfo_firstnum(){

        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        GoodInFo.read_GoodInfo(file_GoodInfo);
        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        PromotionInFo.read_PromotionInfo(file_PromotionInfo);
        PurchaseInFo purchaseinfo=new PurchaseInFo();
        PurchaseInFo.array_purchaseinfo.clear();
        PurchaseInFo.array_purchaseinfo_num.clear();
        purchaseinfo.set_Array("ITEM000000",1);
        //float result=PurchaseInFo.calculate_NormalInfo();
        //result为0并没有得到计算
        //Assert.assertEquals("3.00", result);
        int result= PurchaseInFo.array_purchaseinfo_num.get(0);
        Assert.assertEquals(1, result);
    }
    @Test //买二赠一计算-单独买一个正常的可乐价钱-普通
    public void should_return_purchaseinfo_com_price_one_3(){
        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        GoodInFo.read_GoodInfo(file_GoodInfo);
        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        PromotionInFo.read_PromotionInfo(file_PromotionInfo);
        PurchaseInFo purchaseinfo=new PurchaseInFo();
        PurchaseInFo.array_purchaseinfo.clear();
        PurchaseInFo.array_purchaseinfo_num.clear();
        purchaseinfo.set_Array("ITEM000000",1);
        purchaseinfo.set_Array("#", 1);
        float result= PurchaseInFo.calculate_NormalInfo(array_dis);
        //如何保证控制格式
        Assert.assertEquals("3.0",String.valueOf(result));
    }

    @Test //买二赠一计算-单独买一个正常的可乐优惠钱数
    public void should_return_purchaseinfo_pro_price_one_0(){

        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        GoodInFo.read_GoodInfo(file_GoodInfo);
        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        PromotionInFo.read_PromotionInfo(file_PromotionInfo);
        PurchaseInFo purchaseinfo=new PurchaseInFo();
        PurchaseInFo.array_purchaseinfo.clear();
        PurchaseInFo.array_purchaseinfo_num.clear();
        purchaseinfo.set_Array("ITEM000000",1);
        purchaseinfo.set_Array("#", 1);
        purchaseinfo.all_moneyCharge=0;
        float result= PurchaseInFo.calculate_PromotionInfo();
        //非促销产品
        Assert.assertEquals("0.0",String.valueOf(result));
    }

    @Test //买二赠一计算-单独买一个正常的可乐价钱-总价
    public void should_return_purchaseinfo_all_price_one_3(){

        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        GoodInFo.read_GoodInfo(file_GoodInfo);
        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        PromotionInFo.read_PromotionInfo(file_PromotionInfo);
        PurchaseInFo purchaseinfo=new PurchaseInFo();
        PurchaseInFo.array_purchaseinfo.clear();
        PurchaseInFo.array_purchaseinfo_num.clear();
        purchaseinfo.set_Array("ITEM000000",1);
        purchaseinfo.set_Array("#", 1);
        PurchaseInFo.all_moneyCharge=0;
        PurchaseInFo.all_money=0;
        PurchaseInFo.calculate_NormalInfo(array_dis);
        PurchaseInFo.calculate_PromotionInfo();
        String result= PurchaseInFo.calculate_AllInfo();
        //非促销产品
        Assert.assertEquals("3.0",result);
    }

    @Test //买二赠一计算-买3个正常的可乐价钱-普通
    public void should_return_purchaseinfo_com_price_three_6(){

        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        GoodInFo.read_GoodInfo(file_GoodInfo);
        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        PromotionInFo.read_PromotionInfo(file_PromotionInfo);
        PurchaseInFo purchaseinfo=new PurchaseInFo();
        PurchaseInFo.array_purchaseinfo.clear();
        PurchaseInFo.array_purchaseinfo_num.clear();
        purchaseinfo.set_Array("ITEM000000",3);
        purchaseinfo.set_Array("#", 1);
        float result= PurchaseInFo.calculate_NormalInfo(array_dis);
        //如何保证控制格式
        Assert.assertEquals("6.0",String.valueOf(result));
    }

    @Test //买二赠一计算-买3个正常的可乐优惠钱数
    public void should_return_purchaseinfo_pro_price_three_3(){

        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        GoodInFo.read_GoodInfo(file_GoodInfo);
        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        PromotionInFo.read_PromotionInfo(file_PromotionInfo);
        PurchaseInFo purchaseinfo=new PurchaseInFo();
        PurchaseInFo.array_purchaseinfo.clear();
        PurchaseInFo.array_purchaseinfo_num.clear();
        purchaseinfo.set_Array("ITEM000000",3);
        purchaseinfo.set_Array("#", 1);
        purchaseinfo.all_moneyCharge=0;
        float result= PurchaseInFo.calculate_PromotionInfo();
        //促销产品
        Assert.assertEquals("3.0",String.valueOf(result));
    }

    @Test //买二赠一计算-买3个正常的可乐价钱-总价
    public void should_return_purchaseinfo_all_price_three_6(){

        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        GoodInFo.read_GoodInfo(file_GoodInfo);
        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        PromotionInFo.read_PromotionInfo(file_PromotionInfo);
        PurchaseInFo purchaseinfo=new PurchaseInFo();
        PurchaseInFo.array_purchaseinfo.clear();
        PurchaseInFo.array_purchaseinfo_num.clear();
        purchaseinfo.set_Array("ITEM000000",3);
        purchaseinfo.set_Array("#", 3);
        PurchaseInFo.all_moneyCharge=0;
        PurchaseInFo.all_money=0;
        PurchaseInFo.calculate_NormalInfo(array_dis);
        PurchaseInFo.calculate_PromotionInfo();
        String result= PurchaseInFo.calculate_AllInfo();
        //非促销产品
        Assert.assertEquals("6.0",result);
    }

    /*@Test //判断冲突解决问题
    public void discountInFo_should_return_1() {
        DiscountInFo.read_DiscountInfo("src/main/resources/discountInfo.txt");
        ArrayList<String> dis = DiscountInFo.conflict_resolution();
        int result=dis.size();
        for(int i=0;i<dis.size();i++){
            System.out.println(dis.get(i));
        }
        Assert.assertEquals("1", String.valueOf(result));
    }*/
    @Test //判断冲突输出问题
    public void conflict_should_return_120() {
        PurchaseInFo purchaseinfo = new PurchaseInFo();
        GoodInFo goodInFo = new GoodInFo();
        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        goodInFo.read_GoodInfo(file_GoodInfo);
        //String file_PromotionInfo = "discountInfo.txt";
        ArrayList<String> dis = DiscountInFo.read_DiscountInfo("src/main/resources/discountInfo.txt");
        PurchaseInFo PurchaseInFo = new PurchaseInFo();

        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        PromotionInFo.read_PromotionInfo(file_PromotionInfo);
        PurchaseInFo.array_purchaseinfo.clear();
        PurchaseInFo.array_purchaseinfo_num.clear();
        purchaseinfo.set_Array("ITEM000004",3);
        purchaseinfo.set_Array("#", 1);
        PurchaseInFo.all_moneyCharge=0;
        PurchaseInFo.all_money=0;
        PurchaseInFo.calculate_NormalInfo(array_dis);
        PurchaseInFo.calculate_PromotionInfo();
        String result= PurchaseInFo.calculate_AllInfo();
        //非促销产品
        Assert.assertEquals("120.0",result);
    }
}
