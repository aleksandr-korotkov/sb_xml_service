package sevices;

import common.interfaces.SerializeService;
import entities.Par;

import java.io.*;
import java.util.List;

public class SerializeServiceImpl implements SerializeService {

    private static final String DOC_FILE_NAME = "src/main/resources/documents.txt";
    private static final String PAR_FILE_NAME = "src/main/resources/par_attributes.txt";

    @Override
    public void serialize(List documents) {
        final String[] str = {""};
        documents.stream().forEach(doc -> str[0] += doc + "\n");
        serializeString(str[0], DOC_FILE_NAME);
    }

    @Override
    public void serialize(Par par) {
        String str = "";
        final String[] parList = {"par_list elements : " + "\n"};
        par.getParList().stream().forEach(s->{
            parList[0] += "value = " + s.getValue() + "\n";
        });
        str = "step = " + par.getStep() + "\n" +
                "name = " + par.getName() + "\n" +
                "fullname = " + par.getFullName() + "\n" +
                "comment = " + par.getComment() + "\n" +
                "isEditable = " + par.getIsEditable() + "\n" +
                "isScanable = " + par.getIsScanable() + "\n" +
                "isVisible = " + par.getIsVisible() + "\n" +
                "isRequired = " + par.getIsRequired() + "\n" +
                "isPrinted = " + par.getIsPrinted() + "\n" +
                "isValidateOnLine = " + par.getIsValidateOnLine() + "\n" +
                "type = " + par.getType() + "\n" +
                "min_length = " + par.getMinLength() + "\n" +
                "max_length = " + par.getMaxLength() + "\n" +
                "double_input = " + par.getDoubleInput() + "\n" +
                "value = " + par.getValue() + "\n" +
                "reg_exp = " + par.getRegExp() + "\n" +
                "from_debt = " + par.getFromDebt() + "\n" +
                parList[0] ;
        serializeString(str, PAR_FILE_NAME);
    }

    private void serializeString(String str, String fileName) {
        try (FileWriter writer = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)){
            bufferedWriter.write(str);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
