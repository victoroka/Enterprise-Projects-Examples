package com.br.lp3.model.entities;

import com.br.lp3.model.entities.Postlike;
import com.br.lp3.model.entities.Postlist;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-24T16:01:41")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, String> posttext;
    public static volatile SingularAttribute<Post, Date> postdate;
    public static volatile ListAttribute<Post, Postlike> postlikeList;
    public static volatile SingularAttribute<Post, Long> idPost;
    public static volatile ListAttribute<Post, Postlist> postlistList;

}