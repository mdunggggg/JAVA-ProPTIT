package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static <T> void writeFileListObject(String file, List<T> list){
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static <T> List<T> readFileListObject(String file){
        List<T>list = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    public static <T> void writeFileObject(T t, String path){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            if(hasObject(path) == false){
                fos = new FileOutputStream(path);
                oos = new ObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(path, true);
                oos = new ObjectOutputStream(fos){
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }
            oos.writeObject(t);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fos != null){
                try{
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(oos != null){
                try{
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    public static <T> void readFileObject(String path){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            while(fis.available() > 0){
                Object obj = ois.readObject();
                System.out.println(obj);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(fis != null){
                try{
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(ois != null){
                try{
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static boolean hasObject(String path){
        FileInputStream fis;
        boolean check = true;
        try{
            fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            if(ois.readObject() == null)
                check = false;
            ois.close();
        }
        catch (FileNotFoundException e) {
            check = false;
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }
}
