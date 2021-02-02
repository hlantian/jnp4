http://www.51gjie.com/java/686.html

# Java IO流详解

流(stream)的概念源于UNIX中管道(pipe)的概念。在UNIX中，管道是一条不间断的字节流，用来实现程序或进程间的通信，或读写外围设备、外部文件等。一个流，必有源端和目的端，它们可以是计算机内存的某些区域，也可以是磁盘文件，甚至可以是Internet上的某个URL。实际上，流的源端和目的端可简单地看成是字节的生产者和消费者，对输入流，可不必关心它的源端是什么，只要简单地从流中读数据，而对输出流，也可不知道它的目的端，只是简单地往流中写数据。

流是一组有顺序的，有起点和终点的字节集合，是对数据传输的总称或抽象。即数据在两设备间的传输称为流，流的本质是数据传输，根据数据传输特性将流抽象为各种类，方便更直观的进行数据操作。 

## 类图结构

![IO](IO.png)

## 分类
1. 根据处理数据类型的不同分为：字符流和字节流。
2. 根据数据流向不同分为：输入流和输出流。

## Java字节流
### 1. FileInputStream和FileOutputStream

这两个类属于结点流，第一个类的源端和第二个类的目的端都是磁盘文件，它们的构造方法允许通过文件的路径名来构造相应的流。如：
``` 
FileInputStream infile = new FileInputStream("myfile.dat");
FileOutputStream outfile = new FileOutputStream("results.dat");
```
要注意的是，构造FileInputStream, 对应的文件必须存在并且是可读的，而构造FileOutputStream时，如输出文件已存在，则必须是可覆盖的。
### 2. BufferedInputStream和BufferedOutputStream

它们是过滤器流，其作用是提高输入输出的效率。
### 3. DataInputStream和DataOutputStream

这两个类创建的对象分别被称为数据输入流和数据输出流。这是很有用的两个流，它们允许程序按与机器无关的风格读写Java数据。所以比较适合于网络上的数据传输。这两个流也是过滤器流，常以其它流如InputStream或OutputStream作为它们的输入或输出。

## Java的字符流
字符流主要是用来处理字符的。Java采用16位的Unicode来表示字符串和字符，对应的字符流按输入和输出分别称为readers和writers。

### 1. InputStreamReader和OutputStreamWriter
在构造这两个类对应的流时，它们会自动进行转换，将平台缺省的编码集编码的字节转换为Unicode字符。对英语环境，其缺省的编码集一般为ISO8859-1。

### 2. BufferedReader和BufferedWriter
这两个类对应的流使用了缓冲，能大大提高输入输出的效率。这两个也是过滤器流，常用来对InputStreamReader和OutputStreamWriter进行处理。

## 用法分析
### (1) 按数据来源（去向）使用
- 是文件： FileInputStream, FileOutputStream, FileReader, FileWriter
- 是byte[]：ByteArrayInputStream, ByteArrayOutputStream
- 是Char[]: CharArrayReader, CharArrayWriter
- 是String: StringBufferInputStream, StringReader, StringWriter
- 网络数据流：InputStream, OutputStream, Reader, Writer 

### (2) 按是否格式化输出使用
要格式化输出：PrintStream, PrintWriter 

### (3) 按是否要缓冲使用
要缓冲：BufferedInputStream, BufferedOutputStream, BufferedReader, BufferedWriter。

### (4) 按数据格式使用
二进制格式（只要不能确定是纯文本的）: InputStream, OutputStream及其所有带Stream结束的子类
纯文本格式（含纯英文与汉字或其他编码方式）；Reader, Writer及其所有带Reader, Writer的子类 

### (5) 按输入输出使用
输入：Reader, InputStream类型的子类；输出：Writer, OutputStream类型的子类 

### (6) 特殊需要
- 从Stream到Reader,Writer的转换类：InputStreamReader, OutputStreamWriter
- 对象输入输出：ObjectInputStream, ObjectOutputStream
- 进程间通信：PipeInputStream, PipeOutputStream, PipeReader, PipeWriter 
- 合并输入：SequenceInputStream
- 更特殊的需要：PushbackInputStream, PushbackReader, LineNumberInputStream, LineNumberReader

### (7) 决定使用哪个类以及它的构造进程的一般准则如下（不考虑特殊需要）： 
考虑最原始的数据格式是什么：是否为文本？是输入还是输出?是否需要转换流：InputStreamReader, OutputStreamWriter?数据来源（去向）是什么：文件？内存？网络？是否要缓冲：bufferedReader （特别注明：一定要注意的是readLine()是否有定义，有什么比read, write更特殊的输入或输出方法）是否要格式化输出：print。

## 字符流与字节流转换
### 1. 转换流的特点：
- 其是字符流和字节流之间的桥梁
- 可对读取到的字节数据经过指定编码转换成字符
- 可对读取到的字符数据经过指定编码转换成字节

### 2. 何时使用转换流？
- 当字节和字符之间有转换动作时；
- 流操作的数据需要编码或解码时。

### 3. 具体的对象体现
- InputStreamReader:字节到字符的桥梁
- OutputStreamWriter:字符到字节的桥梁
## 例子
### 1. 实现了字符串的复制 
见FileOutputStreamCopy.java
### 2. FileOutputStream实现复制功能
