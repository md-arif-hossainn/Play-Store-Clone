package com.arif.playstoredesign.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arif.playstoredesign.R
import com.arif.playstoredesign.adapter.AppsTopChatsAdapter
import com.arif.playstoredesign.adapter.FacebookRecyclerAdapter
import com.arif.playstoredesign.adapter.MultiplayerGameAdapter
import com.arif.playstoredesign.adapter.PopularGameAdapter
import com.arif.playstoredesign.adapter.PremiumAdapter
import com.arif.playstoredesign.adapter.SuggestAdapter
import com.arif.playstoredesign.adapter.SuggestForYouAdapter
import com.arif.playstoredesign.adapter.ViewTypeAdapter
import com.arif.playstoredesign.data_model.DataSet
import com.arif.playstoredesign.databinding.FragmentForYouBinding
import com.arif.playstoredesign.models.MediaObject
import com.arif.playstoredesign.utils.setImage
import com.arif.playstoredesign.utils_video.PlayerViewAdapter.Companion.playIndexThenPausePreviousPlayer
import com.arif.playstoredesign.utils_video.PlayerViewAdapter.Companion.releaseAllPlayers
import com.arif.playstoredesign.utils_video.RecyclerViewScrollListener
import com.bumptech.glide.Glide


class ForYouFragment : Fragment() {

    private lateinit var binding: FragmentForYouBinding
    private val viewModel by activityViewModels<ShareViewModel>()


    private var recyclerView: RecyclerView? = null
    private var mAdapter: FacebookRecyclerAdapter? = null
    private val modelList = ArrayList<MediaObject>()

    // for handle scroll and get first visible item index
    private lateinit var scrollListener: RecyclerViewScrollListener


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentForYouBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Glide
//            .with(requireContext())
//            .asGif()
//            .load(R.raw.image4)
//            .into(binding.imageGif)
        //requireContext().setImage(binding.gamesLayoutID.mainImage,R.raw.image4)

        val recyclerView = binding.gamesLayoutID.videoRecyclerView

        mAdapter = FacebookRecyclerAdapter(requireActivity(), modelList)


        val layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = mAdapter

        scrollListener = object : RecyclerViewScrollListener() {
            override fun onItemIsFirstVisibleItem(index: Int) {
                Log.d("visible item index", index.toString())
                // play just visible item
                if (index != -1)
                    playIndexThenPausePreviousPlayer(index)
            }
        }

        recyclerView!!.addOnScrollListener(scrollListener)
        mAdapter!!.SetOnItemClickListener(object :
            FacebookRecyclerAdapter.OnItemClickListener {
            override fun onItemClick(view: View?, position: Int, model: MediaObject?) {

            }
        })

        val model: MediaViewModel by viewModels()
        model.getMedia().observe(requireActivity(), Observer {
            mAdapter?.updateList(arrayListOf(*it.toTypedArray()))
        })




        viewModel.flag.observe(viewLifecycleOwner) {
            when (it) {
                Type.GAMES -> {
                    binding.gamesLayoutID.root.visibility = View.VISIBLE
                    binding.appsLayoutID.root.visibility = View.GONE


                    binding.gamesLayoutID.suggestRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val offlineAdapter = SuggestAdapter(DataSet.premiumAppData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.suggestRV.adapter = offlineAdapter


                    binding.gamesLayoutID.popularGameTV.headerNameTV.text = "Popular game"

                    binding.gamesLayoutID.popularGameRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val popularGameAdapter  = PopularGameAdapter(DataSet.twoPosterDataModel) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.popularGameRV.adapter = popularGameAdapter

                    binding.gamesLayoutID.suggestForYouTV2.headerNameTV.text = "Suggest for you"

                    binding.gamesLayoutID.suggestRV2.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val suggestForYouAdapter  = SuggestForYouAdapter(DataSet.suggestForYouData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.suggestRV2.adapter = suggestForYouAdapter

                    binding.gamesLayoutID.multiPlayerTV.headerNameTV.text = "Multiplayer games"

                    binding.gamesLayoutID.multiPlayerRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val pGameAdapter  = MultiplayerGameAdapter(DataSet.multiPlayerAppData) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.multiPlayerRV.adapter = pGameAdapter


                    binding.gamesLayoutID.sportsGameTV.headerNameTV.text = "Sports games"

                    binding.gamesLayoutID.sportsRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val viewTypeAdapter  = ViewTypeAdapter(DataSet.viewTypeDataModel) // Replace DataSet.parentList with your data
                    binding.gamesLayoutID.sportsRV.adapter = viewTypeAdapter


                }


                Type.APPS -> {
                    binding.gamesLayoutID.root.visibility = View.GONE
                    binding.appsLayoutID.root.visibility = View.VISIBLE

                    binding.appsLayoutID.editVideoTV.headerNameTV.text = "Edit videos like a pro"
                    binding.appsLayoutID.editRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val offlineAdapter = SuggestAdapter(DataSet.editVideoAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.editRV.adapter = offlineAdapter


                    binding.appsLayoutID.suggestForYouTV.headerNameTV.text = "Suggested for you"

                    binding.appsLayoutID.suggestRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val stylizedAdapter = SuggestForYouAdapter(DataSet.suggestForYouData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.suggestRV.adapter = stylizedAdapter


                    binding.appsLayoutID.basedOnRecentTV.headerNameTV.text = "Based on your recent activity"
                    binding.appsLayoutID.basedOnRecentRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val recentData = SuggestAdapter(DataSet.recentAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.basedOnRecentRV.adapter = recentData


                    binding.appsLayoutID.recommendedTV.headerNameTV.text = "Recommended for you"
                    binding.appsLayoutID.recommendedRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val recommendedData = SuggestAdapter(DataSet.recommendAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.recommendedRV.adapter = recommendedData


                    binding.appsLayoutID.newsMagazineTV.headerNameTV.text = "News & magazines"

                    binding.appsLayoutID.newsMagazineRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val magazine = SuggestAdapter(DataSet.premiumAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.newsMagazineRV.adapter = magazine

                    binding.appsLayoutID.suggestForYouTV2.headerNameTV.text = "Suggested for you"


                    binding.appsLayoutID.suggestRV2.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val suggest2 = SuggestForYouAdapter(DataSet.suggestForYouData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.suggestRV2.adapter = suggest2


                    binding.appsLayoutID.justUpdateTV.headerNameTV.text = "Just updated"

                    binding.appsLayoutID.justUpdateRV.layoutManager = LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,false)
                    val update = SuggestAdapter(DataSet.editVideoAppData) // Replace DataSet.parentList with your data
                    binding.appsLayoutID.justUpdateRV.adapter = update
                }

                else -> {}
            }
        }


    }

    override fun onPause() {
        super.onPause()
        releaseAllPlayers()
    }


}