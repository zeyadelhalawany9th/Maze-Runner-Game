/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class ArmorFactory {
   public static ArmorDecorator creatArmor()
   {
       return new ArmorDecorator();
   }
}
