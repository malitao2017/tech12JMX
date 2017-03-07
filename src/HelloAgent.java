import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import com.sun.jdmk.comm.HtmlAdaptorServer;

/**
 * 3.创建MBeanServer
	* 先创建了一个MBeanServer，用来做MBean的容器
    * 将Hello这个类注入到MBeanServer中，注入需要创建一个ObjectName类
    * 创建一个AdaptorServer，这个类将决定MBean的管理界面，这里用最普通的Html型界面。AdaptorServer其实也是一个MBean。
    * chengang:name=HelloWorld的名字是有一定规则的，格式为：“域名:name=MBean名称”，域名和MBean名称都可以任意取。

4、运行HelloAgent，然后打开网页：http://localhost:8082/
    单击“name=HelloWorld”链接进入
5、总结
　　在实际系统中我们可以把name变成决定数库链接池的变量，这样我就可以对系统的运行参数进行实现的监控和配置（管理）。而且也可以对一些方法（如printHello）进行远程调用了。

 * @author malitao
 *
 */
public class HelloAgent {

    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = MBeanServerFactory.createMBeanServer();

        ObjectName helloName = new ObjectName("chengang:name=HelloWorld");
        mBeanServer.registerMBean(new Hello(), helloName);

        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapterServer = new HtmlAdaptorServer();
        mBeanServer.registerMBean(adapterServer, adapterName);

        adapterServer.start();
        System.out.println("start.....");

    }
}