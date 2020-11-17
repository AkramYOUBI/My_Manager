package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AeroportDaoImpl;
import dao.EquipementDaoImpl;
import dao.IAeroportDao;
import dao.IEquipementDao;
import dao.IProjetDao;
import dao.ITypeDao;
import dao.ProjetDaoImpl;
import dao.TypeDaoImpl;
import metier.entities.Aeroport;
import metier.entities.Equipement;
import metier.entities.Projet;
import metier.entities.Ttype;

public class ControlleurServlet extends HttpServlet {
	private IEquipementDao metier;
	private IAeroportDao metier1;
	private IProjetDao metier2;
	private ITypeDao metier3;

	@Override
	public void init() throws ServletException {
		metier = new EquipementDaoImpl();
		metier1 = new AeroportDaoImpl();
		metier2= new ProjetDaoImpl();
		metier3= new TypeDaoImpl();
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String path = request.getServletPath(); /* retoune /chercher.do */
		if (path.equals("/index.do")) {
			if(session.getAttribute("connected")==null) 
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else 
			{
				request.getRequestDispatcher("equipements.jsp").forward(request, response);
				
			}
			
			}

		else if (path.equals("/chercher.do")) { /*
												 * chercher les equipements + retourner une liste des equipements par
												 * Numero de series
											 */
			if(session.getAttribute("connected")==null) 
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else 
			{
			String numero_serie = request.getParameter("numero_serie");
			EquipementModel model = new EquipementModel();
			model.setNumero_serie(numero_serie);
			List<Equipement> equipements = metier.equipementsParNS("%" + numero_serie  + "%");
			model.setEquipement(equipements); /* stocker dans produits */
			request.setAttribute("model", model); /* stocker dans objet request */
			request.getRequestDispatcher("equipements.jsp").forward(request, response);
			}
		}
		else if (path.equals("/admin.do")) 
		{
			if(session.getAttribute("connected")==null) 
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else 
			{
				Aeromodel amodel = new Aeromodel();
				Projetmodel pmodel = new Projetmodel();
				Typemodel tmodel = new Typemodel();
				List<Aeroport> aeroports = metier1.aeroports();
				amodel.setAeroports(aeroports);
				List<Projet> projets = metier2.projets();
				pmodel.setProjets(projets);
				List<Ttype> types = metier3.types();
				tmodel.setTypes(types);
				
				
				
				
				request.setAttribute("amodel", amodel);
				request.setAttribute("pmodel", pmodel);
				request.setAttribute("tmodel", tmodel);
				request.getRequestDispatcher("pageAdmin.jsp").forward(request, response);
		
			}
		}

		else if (path.equals("/Saisie.do")) {
			/* request.setAttribute("Equipement", new Equipement()); */
			
			if(session.getAttribute("connected")==null) 
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else 
			{
			Aeromodel amodel = new Aeromodel();
			 List<Aeroport> aeroports = metier1.aeroports();
			amodel.setAeroports(aeroports); 
			  
			Projetmodel pmodel = new Projetmodel();
			 List<Projet> projets = metier2.projets();
			pmodel.setProjets(projets); 
			
			Typemodel tmodel = new Typemodel();
			 List<Ttype> types = metier3.types();
			tmodel.setTypes(types); 
			
			request.setAttribute("amodel", amodel);
			request.setAttribute("pmodel", pmodel);
			request.setAttribute("tmodel", tmodel);
			
			request.getRequestDispatcher("SaisieEquipement.jsp").forward(request, response);
			}

		}

		else if (path.equals("/SaveEquipement.do")
				&& (request.getMethod().equals("POST"))) {
			
			/* pour accepter just dopost et non pas do get */
			if(session.getAttribute("connected")==null) 
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else 
			{
			String num_s = request.getParameter("numero_serie");
			String assets_t = request.getParameter("assets_tag");
			String node_n = request.getParameter("node_name");
			String mdl = request.getParameter("model");
			String type = request.getParameter("type");
			String nom_p = request.getParameter("nom_projet");
			String nom_a = request.getParameter("nom_aeroport");
			String emplc = request.getParameter("emplacement");
			String id_t = request.getParameter("id_terminal");
			String nom_z = request.getParameter("nom_zone");
			String id_c = request.getParameter("id_comptoir");
			String etat = request.getParameter("etat");
			String commentaire = request.getParameter("commentaire");
			Equipement e = metier.save(
					new Equipement(num_s, assets_t, node_n, mdl, type, nom_p, nom_a, emplc, id_t, nom_z, id_c, etat, commentaire));
			request.setAttribute("equipement", e);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
			}
		}
		/*
		 * if(emplc.equals("Production")){ Equipement e = metier.save(new
		 * Equipement(num_s, assets_t, type, nom_p, nom_a, emplc, id_t, nom_z, id_c,
		 * etat)); request.setAttribute("equipement", e);
		 */

		/*
		 * } else { Stock s = metier.saves(new Stock(num_s, assets_t, type, nom_p,
		 * nom_a, emplc, etat)); request.setAttribute("stock", s);
		 * request.getRequestDispatcher("ConfirmationStk.jsp").forward(request,
		 * response);
		 * 
		 * }
		 */

		else if (path.equals("/Supprime.do")) {
			if(session.getAttribute("connected")==null) 
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else 
			{
			String numero_serie = request.getParameter("numero_serie");
			metier.deleteEquipement(numero_serie);
			// request.getRequestDispatcher("equipements.jsp").forward(request, response);
			response.sendRedirect("chercher.do?numero_serie=");
			}
		}

		else if (path.equals("/Edit.do")) {
			if(session.getAttribute("connected")==null) 
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else 
			{
			String numero_serie = request.getParameter("numero_serie");
			Equipement e = metier.getEquipement(numero_serie);
			request.setAttribute("equipement", e);
			
			Aeromodel amodel = new Aeromodel();
			 List<Aeroport> aeroports = metier1.aeroports();
			amodel.setAeroports(aeroports); 
			  
			Projetmodel pmodel = new Projetmodel();
			 List<Projet> projets = metier2.projets();
			pmodel.setProjets(projets); 
			
			Typemodel tmodel = new Typemodel();
			 List<Ttype> types = metier3.types();
			tmodel.setTypes(types); 
			
			request.setAttribute("amodel", amodel);
			request.setAttribute("pmodel", pmodel);
			request.setAttribute("tmodel", tmodel);
			
			
			request.getRequestDispatcher("EditEquipement.jsp").forward(request, response);
			}
		}

		else if (path.equals("/UpdateEquipement.do")
				&& (request.getMethod().equals("POST"))) {/* pour accepter just dopost et non pas do get */
			if(session.getAttribute("connected")==null) 
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else 
			{
			String num_s = request.getParameter("numero_serie");
			String assets_t = request.getParameter("assets_tag");
			String node_n = request.getParameter("node_name");
			String mdl = request.getParameter("model");
			String type = request.getParameter("type");
			String nom_p = request.getParameter("nom_projet");
			String nom_a = request.getParameter("nom_aeroport");
			String emplc = request.getParameter("emplacement");
			String id_t = request.getParameter("id_terminal");
			String nom_z = request.getParameter("nom_zone");
			String id_c = request.getParameter("id_comptoir");
			String etat = request.getParameter("etat");
			String commentaire = request.getParameter("commentaire");
			Equipement e = new Equipement(num_s, assets_t, node_n, mdl, type, nom_p, nom_a, emplc, id_t, nom_z, id_c,
					etat, commentaire);
			metier.update(e);
			request.setAttribute("equipement", e);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
			}
		}	
		
		 
		  else if (path.equals("/RP.do")) {
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
			  String nom_aeroport = request.getParameter("nom_aeroport");
			  String nom_projet = request.getParameter("nom_projet");
			  String id_terminal = request.getParameter("id_terminal");
			  String nom_zone = request.getParameter("nom_zone");
			  String id_comptoir = request.getParameter("id_comptoir");
			  String model = request.getParameter("model");
			  EquipementModel mmodel = new EquipementModel();
				/* mmodel.setNumero_serie(); */
			  List<Equipement> equipements = metier.equipementsParRP(nom_aeroport,nom_projet,id_terminal,nom_zone, id_comptoir,model);
			  mmodel.setEquipement(equipements); /* stocker dans produits */
			  request.setAttribute("mmodel", mmodel); /* stocker dans objet request */
			  request.getRequestDispatcher("equipements2.jsp").forward(request, response);
				}
			  
			  
			  
		  }
		  else if (path.equals("/aSupprime.do")) {
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
					{
						String nomAeroport = request.getParameter("nomAeroport");
						metier1.deleteAeroport(nomAeroport);
						// request.getRequestDispatcher("equipements.jsp").forward(request, response);
						response.sendRedirect("admin.do");
					}
				}
			}
		  else if (path.equals("/aEdit.do")) {
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
				{
				String nomAeroport = request.getParameter("nomAeroport");
				Aeroport a = metier1.getAeroport(nomAeroport);
				request.setAttribute("aeroport", a);
				request.getRequestDispatcher("AEdit.jsp").forward(request, response);
				}
			}}
		  else if (path.equals("/aUpdate.do")
					&& (request.getMethod().equals("POST"))) {/* pour accepter just dopost et non pas do get */
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else {
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
				{
				String nomAeroportN = request.getParameter("nomAeroportN");
				String nomAeroportA = request.getParameter("nomAeroportA");
				
				Aeroport aN = new Aeroport(nomAeroportN);
				Aeroport aA = new Aeroport(nomAeroportA);
				metier1.update(aN,aA);
				
				response.sendRedirect("admin.do");
				}
			}}
		  else if (path.equals("/aSave.do")
					&& (request.getMethod().equals("POST"))) {/* pour accepter just dopost et non pas do get */
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{if(session.getAttribute("fct")==null) 
				{
					request.getRequestDispatcher("index.do").forward(request, response);
					
				}else 
			{
				String nomAeroport = request.getParameter("nomAeroport");
				
				Aeroport a = metier1.save(
						new Aeroport(nomAeroport));
				request.getRequestDispatcher("admin.do").forward(request, response);
				}
			}}
		
		
		
		  else if (path.equals("/pSupprime.do")) {
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{if(session.getAttribute("fct")==null) 
				{
					request.getRequestDispatcher("index.do").forward(request, response);
					
				}else 
			{
				String nomProjet = request.getParameter("nomProjet");
				metier2.deleteProjet(nomProjet);
				// request.getRequestDispatcher("equipements.jsp").forward(request, response);
				response.sendRedirect("admin.do");
				}
			}}
		  else if (path.equals("/pEdit.do")) {
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
				{
				String nomProjet = request.getParameter("nomProjet");
				Projet p = metier2.getProjet(nomProjet);
				request.setAttribute("projet", p);
				request.getRequestDispatcher("PEdit.jsp").forward(request, response);
				}
			}}
		  else if (path.equals("/pUpdate.do")
					&& (request.getMethod().equals("POST"))) {/* pour accepter just dopost et non pas do get */
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
				{
				String nomProjetN = request.getParameter("nomProjetN");
				String nomProjetA = request.getParameter("nomProjetA");
				
				Projet pN = new Projet(nomProjetN);
				Projet pA = new Projet(nomProjetA);
				metier2.update(pN,pA);
				
				response.sendRedirect("admin.do");
				}
			}}
		  else if (path.equals("/pSave.do")
					&& (request.getMethod().equals("POST"))) {/* pour accepter just dopost et non pas do get */
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
				{
				String nomProjet = request.getParameter("nomProjet");
				
				Projet p = metier2.save(new Projet(nomProjet));
				request.getRequestDispatcher("admin.do").forward(request, response);
				}
			}}
		
		
		
		  else if (path.equals("/tSupprime.do")) {
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
				{
				String type = request.getParameter("type");
				metier3.deleteType(type);
				// request.getRequestDispatcher("equipements.jsp").forward(request, response);
				response.sendRedirect("admin.do");
				}
			}}
		  else if (path.equals("/tEdit.do")) {
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
				{
				String type = request.getParameter("type");
				Ttype t = metier3.getType(type);
				request.setAttribute("type", t);
				request.getRequestDispatcher("TEdit.jsp").forward(request, response);
				}
			}}
		  else if (path.equals("/tUpdate.do")
					&& (request.getMethod().equals("POST"))) {/* pour accepter just dopost et non pas do get */
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
				{
				String typeN = request.getParameter("typeN");
				String typeA = request.getParameter("typeA");
				
				Ttype aN = new Ttype(typeN);
				Ttype aA = new Ttype(typeA);
				metier3.update(aN,aA);
				
				response.sendRedirect("admin.do");
				}
			}}
		  else if (path.equals("/tSave.do")
					&& (request.getMethod().equals("POST"))) {/* pour accepter just dopost et non pas do get */
			  if(session.getAttribute("connected")==null) 
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else 
				{
					if(session.getAttribute("fct")==null) 
					{
						request.getRequestDispatcher("index.do").forward(request, response);
						
					}else 
				{
				String type = request.getParameter("type");
				
				Ttype t = metier3.save(new Ttype(type));
				request.getRequestDispatcher("admin.do").forward(request, response);
				}
			}}
		  else if (path.equals("/logout.do")) {
			  session.invalidate();
			  request.getRequestDispatcher("logout.jsp").forward(request, response);
		  }
		
		

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
