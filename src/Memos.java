import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/")
public class Memos {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Hi(){
        return "Hi, This is My First RESTfullAPI";
    }

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Memo> getMemos(){
        List<Memo> memos = MemoTab.get().getMemos();
        return memos;
    }

    @PUT
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Memo> putMemo(@FormParam("title") String title, @FormParam("text") String text){
        if (title.length()<=30 && text.length() <= 500)
            MemoTab.get().addMemo(title,text);
        List<Memo> memos = MemoTab.get().getMemos();
        return memos;
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Memo> postMemo(@FormParam("id") UUID id, @FormParam("title") String title, @FormParam("text") String text){
        if (title.length()<=30 && text.length() <= 500)
            MemoTab.get().updateMemo(id,title,text);
        List<Memo> memos = MemoTab.get().getMemos();
        return memos;
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Memo> deleteMemo(@FormParam("id") UUID id){
        MemoTab.get().removeMemo(id);
        List<Memo> memos = MemoTab.get().getMemos();
        return memos;
    }
}
