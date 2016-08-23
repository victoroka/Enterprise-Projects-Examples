package com.br.lp3.model.entities;

import com.br.lp3.model.entities.Userlp3;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-23T08:53:03")
@StaticMetamodel(Userinfo.class)
public class Userinfo_ { 

    public static volatile SingularAttribute<Userinfo, Date> birthday;
    public static volatile SingularAttribute<Userinfo, String> firstname;
    public static volatile SingularAttribute<Userinfo, String> latname;
    public static volatile SingularAttribute<Userinfo, Long> idUserinfo;
    public static volatile SingularAttribute<Userinfo, String> email;
    public static volatile SingularAttribute<Userinfo, Userlp3> userlp3;

}