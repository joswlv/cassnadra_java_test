import java.io.*;
import java.util.ArrayList;

/**
 * Created by Jo_seungwan on 2017. 4. 1..
 */
public class FileInput {

    public void getUidData(String uidType, ArrayList<InputModel> uidDataSet) throws Exception {
        File uidFile = null;

        File adidFile = new File(this.getClass().getClassLoader().getResource("DataFile_Adid.txt").toURI());
        File bidFile = new File(this.getClass().getClassLoader().getResource("DataFile_Bid.txt").toURI());
        if (uidType.equals("adid")){
            uidFile = adidFile;
        } else {
            uidFile = bidFile;
        }

        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(uidFile),"UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataLine = line.split(",");
                InputModel inputModel = new InputModel();
                inputModel.setUid(dataLine[0]);
                inputModel.setAgeCode(Integer.parseInt(dataLine[1]));
                inputModel.setGenderCode(Integer.parseInt(dataLine[2]));
                inputModel.setMarriageCode(Integer.parseInt(dataLine[3]));
                inputModel.setCategoryCode(Integer.parseInt(dataLine[4]));

                uidDataSet.add(inputModel);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
