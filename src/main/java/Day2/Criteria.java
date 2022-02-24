package Day2;

import java.io.File;
import java.util.HashMap;

public class Criteria {
    static Boolean includeSubFolder;
    static String folderPath;
    static HashMap<String, Integer> extension = new HashMap<String, Integer>();
    public static void main(String[] args) throws Exception  {

        Criteria criteria = new Criteria();
        criteria.folderPath = "/Users/simengfeng/Desktop/master course";
        File f = new File(criteria.folderPath);
        count(criteria);
        for(String s : extension.keySet()){
            System.out.println("There are " + extension.get(s) + " file(s) inside folder " + f.getName() + " with extension " + s);
        }
    }

    public static void count(Criteria criteria) {
        File f = new File(criteria.folderPath);
        File[] s = f.listFiles();

        for (int i = 0; i < s.length; i++) {
            if (s[i].isDirectory())
                extension.put("folder", extension.getOrDefault("folder", 0) + 1);
            else if (s[i].getName().endsWith(".txt")) {
                extension.put("txt", extension.getOrDefault("txt", 0) + 1);
            } else if (s[i].getName().endsWith(".pdf")) {
                extension.put("pdf", extension.getOrDefault("txt", 0) + 1);
            } else if (s[i].getName().endsWith(".doc")) {
                extension.put("doc", extension.getOrDefault("doc", 0) + 1);
            } else if (s[i].getName().endsWith(".png")) {
                extension.put("doc", extension.getOrDefault("PNG", 0) + 1);
            }
        }
    }
}