import java.util.LinkedList;

public interface Dispatch {

    LinkedList<ProcessStructure> FcFs(LinkedList<ProcessStructure> queue,String currentTime);

    LinkedList<ProcessStructure> SjF(LinkedList<ProcessStructure> queue,String currentTime);

    LinkedList<ProcessStructure> HrrN(LinkedList<ProcessStructure> queue,String currentTime);

    LinkedList<ProcessStructure> HpF(LinkedList<ProcessStructure> queue,String currentTime);

    LinkedList<ProcessStructure> SRTF(LinkedList<ProcessStructure> queue,String currentTime);
}
