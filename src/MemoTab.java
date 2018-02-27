import java.time.Clock;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class MemoTab {
    private static MemoTab sMemoTab;

    private List<Memo> mMemos;

    public static MemoTab get(){
        if (sMemoTab == null){
        sMemoTab = new MemoTab();
        }
        return sMemoTab;
    }

    private MemoTab(){
        mMemos = new ArrayList<>();
        for (int i = 0; i<2; i++){
            Memo memo = new Memo();
            memo.setTitle("Memo "+ i);
            memo.setText("My title "+ i);
            mMemos.add(memo);
        }
    }

    public List<Memo> getMemos() {
        return mMemos;
    }

    public void addMemoStatic(){
        Memo memo = new Memo();
        memo.setTitle("MyMemo 1");
        memo.setText("MyMemo 1");
        mMemos.add(memo);
    }

    public void addMemo(String title, String text){
        Memo memo = new Memo(title,text);
        mMemos.add(memo);
    }

    public void removeMemo(UUID id){
        List<Memo> remMemo = new ArrayList<>();
        Iterator<Memo> iteratorMemos = mMemos.iterator();
        while (iteratorMemos.hasNext()){
            Memo thisMemmos = (Memo)iteratorMemos.next();
            if (!thisMemmos.getId().equals(id))
                remMemo.add(thisMemmos);
        }
        mMemos = remMemo;
    }

    public void updateMemo(UUID id, String title, String text){
        List<Memo> upMemo = new ArrayList<>();
        Iterator<Memo> iteratorMemos = mMemos.iterator();
        while (iteratorMemos.hasNext()) {
            Memo thisMemmos = (Memo) iteratorMemos.next();
            if (!thisMemmos.getId().equals(id))
                upMemo.add(thisMemmos);
            else{
                Memo memo = new Memo();
                memo.setId(thisMemmos.getId());
                memo.setTitle(title);
                memo.setText(text);
                memo.setData_create(thisMemmos.getData_create());
                memo.setData_update(Clock.system(ZoneId.of("UTC+0")).instant().getEpochSecond());
                upMemo.add(memo);
            }
        }
        mMemos = upMemo;
    }

    public Memo getMemo(UUID id){
        for (Memo memo : mMemos){
            if (memo.getId().equals(id)){
                return memo;
            }
        }
        return null;
    }
}