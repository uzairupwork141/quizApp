/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FILES;

/**
 *
 * @author User1
 */
public class backup {
    
    
    public static boolean backupDB(String dbName, String dbUserName, String dbPassword) {

        Process runtimeProcess;
        try {

             runtimeProcess = Runtime.getRuntime().exec("C://xampp//mysql//bin//mysqldump -u "+ dbUserName+" -p"+dbPassword+" --add-drop-database -B "+dbName+"-r D://SQL//backup.sql");

            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup created successfully");
                return true;
            } else {
                System.out.println("Could not create the backup");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    
    
    
    
    public static void main(String args[]) {
         
         System.out.println(backup.backupDB("quizdb","root",""));
         
     }
}
