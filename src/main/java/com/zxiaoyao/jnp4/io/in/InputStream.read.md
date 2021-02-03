# Java InputStream.read()读取数据流字节，存储到缓冲区数组
## 定义
```
public abstract int read()
public int read(byte[] b)
public int read(byte[] b,int off,int len)
```
## 参数:
b：存储读入数据的缓冲区;off:数组 b 中将写入数据的初始偏移量；len：要读取的最大字节数
## 返回：
读入缓冲区的总字节数；如果因为已经到达流末尾而不再有数据可用，则返回 -1。

## 异常抛出：
- IOException: 如果不是因为流位于文件末尾而无法读取第一个字节；如果输入流已关闭；如果发生其他 I/O 错误。
- NullPointerException: 如果b为null
- IndexOutOfBoundsException : 如果off为负数，则len为负数，或len为b.length-off

## 区别
### 1. read()这个方法是对这个流一个一个字节的读，返回的int就是这个字节的int表示方式
见[IOinTest5.test()](#):
```
public void test() {
        InputStream is = null;
        try {
            is = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            byte[] tt = new byte[1024];
            while (is.available() != 0) {
                for (int i = 0; i < 1024; i++) {
                    tt[i] = (byte) is.read();
                }
            }
            System.out.println(new String(tt));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(is);
        }

    }
```
从输入流中读取数据的下一个字节，返回0到255范围内的int字节值。如果因为已经到达流末尾而没有可用的字节，则返回-1。在输入数据可用、检测到流末尾或者抛出异常前，此方法一直阻塞。
### 2. read(byte[] b) 这个方法是先规定一个数组长度，将这个流中的字节缓冲到数组b中，返回的这个数组中的字节个数，这个缓冲区没有满的话，则返回真实的字节个数，到未尾时都返回-1
见[IOinTest5.test2()](#):
```
public void test2() {
        InputStream is = null;
        try {
            is = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            byte[] bytes = new byte[1024];
            int b;
            while ((b = is.read(bytes)) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(is);
        }

    }
```
从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。以整数形式返回实际读取的字节数。在输入数据可用、检测到文件末尾或者抛出异常前，此方法一直阻塞。如果 b 的长度为 0，则不读取任何字节并返回 0；否则，尝试读取至少一个字节。如果因为流位于文件末尾而没有可用的字节，则返回值 -1；否则，至少读取一个字节并将其存储在 b 中。将读取的第一个字节存储在元素 b[0] 中，下一个存储在 b[1] 中，依次类推。读取的字节数最多等于b 的长度。设 k 为实际读取的字节数；这些字节将存储在 b[0] 到 b[k-1] 的元素中，不影响 b[k] 到b[b.length-1] 的元素。
### 3. read(byte[] b, int off, int len) 此方法其实就是多次调用了read()方法
见[IOinTest5.test3()](#)
```
public void test3() {
        InputStream is = null;
        try {
            is = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            byte[] bytes = new byte[is.available()];
            int b;
            while ((b = is.read(bytes, 0, bytes.length)) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(is);
        }
    }
```
1. 将输入流中最多 len 个数据字节读入 byte 数组。尝试读取 len 个字节，但读取的字节也可能小于该值。以整数形式返回实际读取的字节数。
2. 在输入数据可用、检测到流末尾或者抛出异常前，此方法一直阻塞。
3. 如果 len 为 0，则不读取任何字节并返回 0；否则，尝试读取至少一个字节。如果因为流位于文件末尾而没有可用的字节，则返回值 -1；否则，至少读取一个字节并将其存储在 b 中。
4. 将读取的第一个字节存储在元素 b[off] 中，下一个存储在 b[off+1] 中，依次类推。读取的字节数最多等于 len。设k为实际读取的字节数；这些字节将存储在 b[off] 到 b[off+k-1] 的元素中，不影响 b[off+k] 到 b[off+len-1] 的元素。	
5. 在任何情况下，b[0] 到 b[off] 的元素以及 b[off+len] 到 b[b.length-1] 的元素都不会受到影响。
6. 类 InputStream 的 read(b,off,len) 方法重复调用方法 read()。如果第一次这样的调用导致 IOException，则从对 read(b,off,len) 方法的调用中返回该异常。如果对 read() 的任何后续调用导致 IOException，则捕获该异常并将其视为到达文件末尾；到达该点时读取的字节存储在 b 中，并返回发生异常之前读取的字节数。在已读取输入数据 len 的请求数量、检测到文件结束标记、抛出异常前，此方法的默认实现将一直阻塞。建议子类提供此方法更为有效的实现。
### 例子
见[IOinTest5.test5()](#)
```
 public void test5() {
        File file = new File(FileConstants.JAVA_TXT_FILE_PATH);
        FileInputStream inputStream=null;
        try {
            inputStream = new FileInputStream(file);
            byte[] b = new byte[(int)file.length()];
            int len = inputStream.read(b, 0, b.length);
            System.out.println(new String(b));
            System.out.println("b.length== len ? :" + (b.length == len));
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(inputStream);
        }

        try {
            inputStream = new FileInputStream(file);
            byte[] bb = new byte[1024];
            int len2 = inputStream.read(bb);
            System.out.println(new String(bb,0,len2));
            System.out.println("len2 = " + len2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(inputStream);
        }

        try {
            inputStream = new FileInputStream(file);
            byte[] bbb = new byte[(int)file.length()];
            for(int i =0;i<bbb.length;i++){
                bbb[i] = (byte)inputStream.read();
            }
            System.out.println(new String(bbb));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(inputStream);
        }
    }
```
