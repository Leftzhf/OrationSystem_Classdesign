import java.util.LinkedList;

public interface Dispatch {

    void FcFs(LinkedList<ProcessStructure> queue,String currentTime);

    void SjF(LinkedList<ProcessStructure> queue,String currentTime);

    void HrrN(LinkedList<ProcessStructure> queue,String currentTime);

    void HpF(LinkedList<ProcessStructure> queue,String currentTime);

    void SRTF(LinkedList<ProcessStructure> queue,String currentTime);
}
