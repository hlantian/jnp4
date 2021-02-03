## Java File类
java中我们通过java.io.File类实现对文件的基本属性进行操作，包括文件属性读取，文件创建，文件删除，文件添加等等。File是一个类，那么在使用的时候就需要创建对象，但是File类的实例是不可变的，也就是说，一旦创建，由File对象表示的抽象路径名将永远不会改变,也就是说利用构造方法，指定路径名、文件名等来构造File类的对象，之后调用该对象的createNewFile()方法就可以创建出相应的文件。

## File类代表文件路径
File类的对象可以代表一个具体的文件路径，在实际运用种，可以使用绝对路径也可以使用相对路径，下面是创建文件对象实例
```
File f1=new File("d:\\test\\test.txt");
File f2=new File("test.txt");
File f3=new File("d:\\test");
File f4=new File("d:\\test\\","51gjie.txt")
```
f1,f2对象分别代表一个文件，f1是绝对路径，f2是相对路径，f3则是代表一个文件夹，文件夹也是文件路径的一种，f4代表的路径是d:\\test\\51gjie.txt 这种是使用父路径和子路径结合产生新的路径。
## 定义
```
public class File  extends Object  implements Serializable, Comparable<File>
```
## 构造函数
### 1. File(String pathname)
通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。如果给定字符串是空字符串，那么结果是空抽象路径名。

### 2. File(File parent, String child)
根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例,如果 parent 为 null，则创建一个新的 File 实例，这与调用给定 child 路径名字符串的单参数 File 构造方法的效果一样。否则，parent 抽象路径名用于表示目录，child 路径名字符串用于表示目录或文件。如果 child 路径名字符串是绝对路径名，则用与系统有关的方式将它转换为一个相对路径名。如果 parent 是空抽象路径名，则通过将 child 转换为抽象路径名，并根据与系统有关的默认目录解析结果来创建新的 File 实例。否则，将每个路径名字符串转换为一个抽象路径名，并根据父抽象路径名解析子抽象路径名。

### 3. File(String parent, String child)
parent指定路径（父目录），可以是File类对象也可以是字符串，child中也可以加入路径层级，但要注意，所用的路径必须存在，不存在的路径不会新建。

### 4. File(URI uri)
通过将给定的 file: URI转换为一个抽象路径名来创建一个新的 File 实例，这个一般用的比较少。

## 静态成员
```
public static final String pathSeparator
```
路径分割符,在 UNIX 系统上，此字段的值为 '/'；在 Windows 系统上，它为 '\\'。
```
public static final String pathSeparatorChar
```
路径分割符':',在 UNIX 系统上，此字段为 ':'；在Microsoft Windows 系统上，它为 ';'。
```
public static final char separator
```
分隔符"/"
```
public static final char separatorChar
```
## 常用方法
- File.delete() 删除文件或文件夹目录。
- File.createNewFile() 创建一个新的空文件。
- File.mkdir() 创建一个新的空文件夹。
- File.list() 获取指定目录下的文件和文件夹名称。
- File.listFiles() 获取指定目录下的文件和文件夹对象。
- File.exists() 文件或者文件夹是否存在
## 获取FILE属性方法
```
String   getAbsolutePath()   // 获取绝对路径
long   getFreeSpace()       // 返回分区中未分配的字节数。
String   getName()         // 返回文件或文件夹的名称。
String   getParent()         // 返回父目录的路径名字符串；如果没有指定父目录，则返回 null。
File   getParentFile()      // 返回父目录File对象
String   getPath()         // 返回路径名字符串。
long   getTotalSpace()      // 返回此文件分区大小。
long   getUsableSpace()    //返回占用字节数。
int   hashCode()             //文件哈希码。
long   lastModified()       // 返回文件最后一次被修改的时间。
long   length()          // 获取长度,字节数。
boolean canRead()  //判断是否可读
boolean canWrite()  //判断是否可写
boolean isHidden()  //判断是否隐藏
```
## 设置FILE属性方法
```
// 成员函数
static File[]    listRoots()    // 列出可用的文件系统根。
boolean    renameTo(File dest)    // 重命名
boolean    setExecutable(boolean executable)    // 设置执行权限。
boolean    setExecutable(boolean executable, boolean ownerOnly)    // 设置其他所有用户的执行权限。
boolean    setLastModified(long time)       // 设置最后一次修改时间。
boolean    setReadable(boolean readable)    // 设置读权限。
boolean    setReadable(boolean readable, boolean ownerOnly)    // 设置其他所有用户的读权限。
boolean    setWritable(boolean writable)    // 设置写权限。
boolean    setWritable(boolean writable, boolean ownerOnly)    // 设置所有用户的写权限。
```
## 例子
见 [FileTestDemo.java](#)
## 总结
1. File类的直接父类是Object类。一个File类的对象，表示了磁盘上的文件或目录。如果你创建文件或者文件夹忘了写盘符路径，那么，默认在项目路径下。

2. 在不同的计算机操作系统中，路径分割符号是不同的。windows系统的路径分隔符【\】与Unix系统的路径分隔符【/】不一样


 
3. File类提供了与平台无关的方法来对磁盘上的文件或目录进行操作。因为不同的系统平台对文件路径的描述不尽相同，所以为了做到平台无关，在Java语言中，使用抽象路径等概念。Java自动进行不同系统平台的文件路径描述与抽象文件路径之间的转换。


 
4. File对象用来获取或处理与磁盘文件相关的信息，例如权限，时间，日期和目录路径。可以直接处理文件和文件系统，同时还可以浏览子目录层次结构