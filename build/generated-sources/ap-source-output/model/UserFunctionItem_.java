package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.LogUser;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-14T15:58:27")
@StaticMetamodel(UserFunctionItem.class)
public class UserFunctionItem_ { 

    public static volatile SingularAttribute<UserFunctionItem, Long> id;
    public static volatile SingularAttribute<UserFunctionItem, LogUser> userName;
    public static volatile SingularAttribute<UserFunctionItem, String> functionName;

}