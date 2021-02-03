# 获取数据流字节长度大小
## 定义
```
public int available()
```
## 实例
见[IOinTest6.java](#)
```
 public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            System.out.println("len = " + inputStream.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(inputStream);
        }
    }
```
1. 返回可以从此输入流读取（或跳过）而不会被该输入流的方法的下一次调用阻塞的字节数的估计值。 下一个调用可能是同一线程或另一个线程。 仅读取或跳过此多个字节不会阻塞，但可能会读取或跳过较少的字节。
2. 如果这个方法用在从本地文件读取数据时，一般不会遇到问题，但如果是用于网络操作，就经常会遇到一些麻烦。比如，Socket通讯时，对方明明发来了10240个字节，但是自己的程序调用available()方法却只得到800，或者1024，甚至是0。
3. available这个方法一定要在子类中实现，如果实现了那么就可以取得大小，如果没有实现获取就一直是0。
4. 如果已经调用close（）方法关闭了此输入流，调用此方法会抛出IOException异常。