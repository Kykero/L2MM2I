package fr.amine.tp6;

public interface File {
	public boolean fileVide();
	public boolean filePleine();
	public void ajoutFile(int o);
	public int oteFile();
	int nbElement();
	public  String toString();
	public int ithelement(int i);
	public boolean egal(FileArray f);
}//Interface File
