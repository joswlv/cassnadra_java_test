import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jo_seungwan on 2017. 4. 1..
 */
public class FileInput {

    List<InputModel> uidDataSet = new ArrayList<>();
    InputModel inputModel = new InputModel();

    public List<InputModel> getUidData(String uidType) {
        File uidFile = null;

        File adidFile = new File("../resources/DataFile_Adid.txt");
        File bidFile = new File("../resources/DataFile_Bid.txt");
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
                String[] dataLine = line.split("\t");
                inputModel.setUid(dataLine[0]);
                inputModel.setAgeCode(dataLine[1]);
                inputModel.setGenderCode(dataLine[2]);
                inputModel.setMarriageCode(dataLine[3]);
                inputModel.setCategoryCode(dataLine[4]);

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

        return uidDataSet;
    }

}
