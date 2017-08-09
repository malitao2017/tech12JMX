/**
 * 1.Hello是一个需要被管理的类（普通类）
 * @author malitao
 *
 */
public class Hello implements HelloMBean {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void printHello() {
        System.out.println("测试1：Hello World, " + name);
    }
    public void printHello(String whoName) {
        System.out.println("测试2：Hello , " + whoName);
    }
}
