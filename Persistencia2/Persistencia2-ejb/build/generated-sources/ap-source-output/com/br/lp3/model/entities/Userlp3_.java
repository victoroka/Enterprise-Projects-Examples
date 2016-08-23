package com.br.lp3.model.entities;

import com.br.lp3.model.entities.Postlist;
import com.br.lp3.model.entities.Userinfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-23T08:53:03")
@StaticMetamodel(Userlp3.class)
public class Userlp3_ { 

    public static volatile SingularAttribute<Userlp3, String> password;
    public static volatile SingularAttribute<Userlp3, Long> idUserlp3;
    public static volatile SingularAttribute<Userlp3, Userinfo> userinfo;
    public static volatile SingularAttribute<Userlp3, String> username;
    public static volatile ListAttribute<Userlp3, Postlist> postlistList;

}