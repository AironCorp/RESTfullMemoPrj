import java.time.Clock;
import java.time.ZoneId;
import java.util.UUID;

public class Memo {

    private String id;
    private String title;
    private String text;
    private long data_create;
    private long data_update;

    public Memo(String title, String text){
        super();
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.text = text;
        this.data_create = Clock.system(ZoneId.of("UTC+0")).instant().getEpochSecond();
        this.data_update = Clock.system(ZoneId.of("UTC+0")).instant().getEpochSecond();
    }

    public Memo(){
        super();
        this.id = UUID.randomUUID().toString();
        this.title = "";
        this.text = "";
        this.data_create = Clock.system(ZoneId.of("UTC+0")).instant().getEpochSecond();
        this.data_update = Clock.system(ZoneId.of("UTC+0")).instant().getEpochSecond();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getData_create() {
        return data_create;
    }

    public void setData_create(long data_create) {
        this.data_create = data_create;
    }

    public long getData_update() {
        return data_update;
    }

    public void setData_update(long data_update) {
        this.data_update = data_update;
    }
}
