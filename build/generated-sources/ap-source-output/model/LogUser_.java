package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.UserFunctionItem;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-14T15:58:27")
@StaticMetamodel(LogUser.class)
public class LogUser_ { 

    public static volatile SingularAttribute<LogUser, Long> id;
    public static volatile SingularAttribute<LogUser, String> passwd;
    public static volatile ListAttribute<LogUser, UserFunctionItem> userFunctions;
    public static volatile SingularAttribute<LogUser, String> name;

}