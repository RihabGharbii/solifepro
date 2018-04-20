package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import com.example.demo.Result;

@Service
public class SvnService {
	
	public Object getResult() throws SVNException 
	{     	DAVRepositoryFactory.setup( );
	
	String nameproject = "projetvermegpfe";
    String url = "https://subversion.assembla.com/svn/vermeg^vermeg-first-space/"+nameproject;
    
    long startRevision = 0;
    long endRevision = -1; //HEAD (the latest) revision

    SVNRepository repository = null;
        repository = SVNRepositoryFactory.create( SVNURL.parseURIEncoded( url ) );
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager( "m258", "30101994Amine" );
        repository.setAuthenticationManager( authManager );
        Collection logEntries = null;
        
        logEntries = repository.log( new String[] { "" } , null , startRevision , endRevision , true , true );
        com.example.demo.Result resu =new Result();
        		List<com.example.demo.Result> resus = new ArrayList<com.example.demo.Result>();	  
  List<String>Paths=new ArrayList<>();
		  for ( Iterator entries = logEntries.iterator( ); entries.hasNext( ); ) {
        SVNLogEntry logEntry = ( SVNLogEntry ) entries.next( );
        resu.setAutheur(logEntry.getAuthor());
        resu.setRevision(logEntry.getRevision());		
        resu.setMessage(logEntry.getMessage());		
        	resu.setDate(logEntry.getDate());	
        		
         

        	Set<?> changedPathsSet = logEntry.getChangedPaths( ).keySet( );
        for ( Iterator<?> changedPaths = changedPathsSet.iterator( ); changedPaths.hasNext( ); ) {
        		                    SVNLogEntryPath entryPath = ( SVNLogEntryPath ) logEntry.getChangedPaths( ).get( changedPaths.next( ) );
        		                	

        		                   String path = entryPath.getPath().toString();

        		                  Paths.add(path.substring(nameproject.length()+1));
        		                    
        }
        resu.setPath(Paths);
        resus.add(resu);}
	
	return resus ;
	
	
}

}
