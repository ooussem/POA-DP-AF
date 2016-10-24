package fr.paris10.td4;

import fr.paris10.td4.base.AbstractFile;
import fr.paris10.td4.base.OrdinaryFile;
import fr.paris10.td4.base.UserRegistry;

/**
 * Created by ououlhac on 24/10/2016.
 */
public class testBase {

    public static void main(String args[]){

        UserRegistry user= new UserRegistry();
        user.createUser("1");
        AbstractFile of = new OrdinaryFile("toto", "titi");







    }




}
