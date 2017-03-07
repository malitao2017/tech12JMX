/**
 * 2、要管理Hello则必须创建一个相应MBean
 * 说明：包含在MBean中方法都将是可以被管理的。MBean起名是有规范的，就是原类名后加上MBean字样。
 * @author malitao
 *
 */
public interface HelloMBean {
    public String getName();
    public void setName(String name);
    public void printHello();
    public void printHello(String whoName);
}