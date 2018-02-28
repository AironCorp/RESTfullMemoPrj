import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Memo> putMemo(@QueryParam("title") String title,@QueryParam("text") String text){
        String titleNew = title;
        String textNew = text;
        System.out.println(title);
        System.out.println(text);
        if (title.length()<=30 && text.length() <= 500)
            MemoTab.get().addMemo(titleNew,textNew);
        List<Memo> memos = MemoTab.get().getMemos();
        return memos;
    }

    @PUT
    @Path("/posts")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Memo> putMemoS(){
        MemoTab.get().addMemo("1","2");
        List<Memo> memos = MemoTab.get().getMemos();
        return memos;
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Memo> postMemo(@QueryParam("id") String id, @QueryParam("title") String title, @QueryParam("text") String text){
        if (title.length()<=30 && text.length() <= 500)
            MemoTab.get().updateMemo(id,title,text);
        List<Memo> memos = MemoTab.get().getMemos();
        return memos;
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Memo> deleteMemo(@QueryParam("id") String id){
        MemoTab.get().removeMemo(id);
        List<Memo> memos = MemoTab.get().getMemos();
        return memos;
    }
}